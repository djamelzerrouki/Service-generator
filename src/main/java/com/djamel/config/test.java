package com.djamel.config;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.djamel.git.Git;





public class test {
	private static Connection connection;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//	 	File src = new File("C:\\Users\\djamel\\Desktop\\emploi");
		//		File dest = new File("C:\\Users\\djamel\\Desktop\\emploi3");
		//		Path srcPath = src.toPath();
		//		Path destPath = dest.toPath();
		//		Files.walkFileTree(srcPath, new CopyDirVisitor(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING));
		// System.out.println("DON!");
		//deferntDateByDays();
		//	ConfigPOM("jhdhdjdh");	
		ConfigAll("","");
	}

	public static void ConfigAll(String name,String port) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//	ConfigPOM("jhdhdjdh");	
// la configuration de Micro-Service par le nom et le port .
		ConfigBooStrap(name, port);
// la creation de la base de donnée par JDBC .
		creatDataBase(name);
// la Creation BooStrap prepertise dans repo GIT CLOUD
		createGitBooStrap(name);
// git add .		
		Path directory = Paths.get(FinalName.Gitdirectory);
		Git.gitStage(directory);
//git commit -m "adding new MS "		
		Git.gitCommit(directory, "adding "+name);
	}

	//	static long deferntDateByDays( Date dateD, Date dateF) {
	//		 	 long diff=0 ;
	//		 	 if (dateF!=null) {
	//		           diff = dateF.getTime() - dateD.getTime();
	//
	//			} else {
	//		           diff = dateF.getTime() - new Date().getTime();
	//
	//			}
	//		           diff=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	//		//    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	//		 
	//		return diff;
	//	}



	public static class CopyDirVisitor extends SimpleFileVisitor<Path>
	{
		private final Path fromPath;
		private final Path toPath;
		private final CopyOption copyOption;

		public CopyDirVisitor(Path fromPath, Path toPath, CopyOption copyOption)
		{
			this.fromPath = fromPath;
			this.toPath = toPath;
			this.copyOption = copyOption;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
		{
			Path targetPath = toPath.resolve(fromPath.relativize(dir));
			if( !Files.exists(targetPath) )
			{
				Files.createDirectory(targetPath);
			}
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
		{
			Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
			return FileVisitResult.CONTINUE;
		}
	}








	public static  void newMkdirss(String path,String nameModel)  {
		File dir = new File (path);
		dir.mkdirs();
	}

	public static void ConfigPOM(String  name) throws IOException {
		String text = "Hello jimmi";
		//	newMkdirss(FinalName.pathPOM,name);
		newMkdirss("/",name);

		StringBuffer buffer= new StringBuffer() ;
		buffer.append ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\r\n" + 
				"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n" + 
				"	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\r\n" + 
				"	<modelVersion>4.0.0</modelVersion>\r\n" + 
				"	<groupId>org.camunda.bpm.getstarted</groupId>\r\n" + 
				"	<artifactId>"+name+"</artifactId>\r\n" + 
				"	<version>0.0.1-SNAPSHOT</version>\r\n" + 
				"	<packaging>jar</packaging>\r\n" + 
				"	<properties>\r\n" + 
				"		<camunda.spring-boot.version>3.2.0</camunda.spring-boot.version>\r\n" + 
				"		<spring-boot.version>2.1.1.RELEASE</spring-boot.version>\r\n" + 
				"		<maven.compiler.source>1.7</maven.compiler.source>\r\n" + 
				"		<maven.compiler.target>1.7</maven.compiler.target>\r\n" + 
				"		<spring-cloud.version>Greenwich.M3</spring-cloud.version>\r\n" + 
				"		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\r\n" + 
				"		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\r\n" + 
				"		<java.version>1.8</java.version>\r\n" + 
				"		<spring-cloud.version>Greenwich.M3</spring-cloud.version>\r\n" + 
				"\r\n" + 
				"	</properties>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"	<name>service-company</name>\r\n" + 
				"	<description>Demo project for Spring Boot</description>\r\n" + 
				"\r\n" + 
				"	<parent>\r\n" + 
				"		<groupId>org.springframework.boot</groupId>\r\n" + 
				"		<artifactId>spring-boot-starter-parent</artifactId>\r\n" + 
				"		<version>2.1.0.RELEASE</version>\r\n" + 
				"		<relativePath /> <!-- lookup parent from repository -->\r\n" + 
				"	</parent>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"	<dependencies>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.camunda.bpm.springboot</groupId>\r\n" + 
				"			<artifactId>camunda-bpm-spring-boot-starter</artifactId>\r\n" + 
				"			<version>${camunda.spring-boot.version}</version>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-actuator</artifactId>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-data-jpa</artifactId>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-data-rest</artifactId>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-thymeleaf</artifactId>\r\n" + 
				"		</dependency>\r\n" + 
				"\r\n" + 
				"		<!-- <dependency> <groupId>nz.net.ultraq.thymeleaf</groupId> <artifactId>thymeleaf-layout-dialect</artifactId> \r\n" + 
				"			</dependency> <dependency> <groupId>org.thymeleaf.extras</groupId> <artifactId>thymeleaf-extras-springsecurity4</artifactId> \r\n" + 
				"			</dependency> -->\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-security</artifactId>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-web</artifactId>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.cloud</groupId>\r\n" + 
				"			<artifactId>spring-cloud-starter-config</artifactId>\r\n" + 
				"		</dependency>\r\n" + 
				"			 	<dependency>\r\n" + 
				"			<groupId>org.springframework.cloud</groupId>\r\n" + 
				"			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>\r\n" + 
				"		</dependency>  \r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-devtools</artifactId>\r\n" + 
				"			<scope>runtime</scope>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>mysql</groupId>\r\n" + 
				"			<artifactId>mysql-connector-java</artifactId>\r\n" + 
				"			<version>5.1.23</version>\r\n" + 
				"			<scope>runtime</scope>\r\n" + 
				"		</dependency>\r\n" + 
				"		<!-- <dependency> -->\r\n" + 
				"		<!-- <groupId>org.springframework.boot</groupId> -->\r\n" + 
				"		<!-- <artifactId>spring-boot-starter-webflux</artifactId> -->\r\n" + 
				"		<!-- </dependency> -->\r\n" + 
				"\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.projectlombok</groupId>\r\n" + 
				"			<artifactId>lombok</artifactId>\r\n" + 
				"			<optional>true</optional>\r\n" + 
				"		</dependency>\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-test</artifactId>\r\n" + 
				"			<scope>test</scope>\r\n" + 
				"		</dependency>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"	</dependencies>\r\n" + 
				"\r\n" + 
				"	<dependencyManagement>\r\n" + 
				"		<dependencies>\r\n" + 
				"			<dependency>\r\n" + 
				"				<groupId>org.springframework.cloud</groupId>\r\n" + 
				"				<artifactId>spring-cloud-dependencies</artifactId>\r\n" + 
				"				<version>${spring-cloud.version}</version>\r\n" + 
				"				<type>pom</type>\r\n" + 
				"				<scope>import</scope>\r\n" + 
				"			</dependency>\r\n" + 
				"		</dependencies>\r\n" + 
				"	</dependencyManagement>\r\n" + 
				"\r\n" + 
				"	<build>\r\n" + 
				"		<plugins>\r\n" + 
				"			<plugin>\r\n" + 
				"				<groupId>org.springframework.boot</groupId>\r\n" + 
				"				<artifactId>spring-boot-maven-plugin</artifactId>\r\n" + 
				"			</plugin>\r\n" + 
				"		</plugins>\r\n" + 
				"	</build>\r\n" + 
				"\r\n" + 
				"	<repositories>\r\n" + 
				"		<repository>\r\n" + 
				"			<id>spring-milestones</id>\r\n" + 
				"			<name>Spring Milestones</name>\r\n" + 
				"			<url>https://repo.spring.io/milestone</url>\r\n" + 
				"			<snapshots>\r\n" + 
				"				<enabled>false</enabled>\r\n" + 
				"			</snapshots>\r\n" + 
				"		</repository>\r\n" + 
				"	</repositories>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</project>" 
				);


		text=buffer.toString();
		BufferedWriter output = null;
		try {
			File file = new File("pom.xml");
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
			output.flush();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( output != null ) {
				output.close();
			}
		}



	}








	public static void ConfigBooStrap(String name,String port) throws IOException {
		String text = "Hello jimmi";
		//	newMkdirss(FinalName.pathPOM,name);
		newMkdirss("‪C:\\Users\\djamel\\Desktop\\service1\\src\\main\\resources\\bootstrap.properties",name);

		StringBuffer buffer= new StringBuffer() ;
		buffer.append ("################### MS cloud Configuration ##########################\r\n" + 
				"spring.application.name=service-"+name+"\r\n" + 
				"spring.cloud.config.uri=http://localhost:8888\r\n" + 
				"management.endpoints.web.exposure.include=*\r\n" + 
				"server.port="+port+"\r\n" + 
				"################### http path Configuration ##########################\r\n" + 
				"spring.http.multipart.max-file-size=15MB\r\n" + 
				"spring.http.multipart.max-request-size=15MB\r\n" + 
				"spring.devtools.restart.exclude=/public \r\n" + 
				"#spring.devtools.restart.enabled=false\r\n" + 
				"spring.devtools.reload.trigger-file=.reloadtrigger\r\n" + 
				"\r\n" + 
				"################### DataSource Configuration ##########################\r\n" + 
				"spring.datasource.url=jdbc:mysql://localhost:3306/"+name+"\r\n" + 
				"#spring.datasource.jdbcUrl=jdbc:mysql://localhost:3306/mydata\r\n" + 
				"spring.datasource.driverClassName=com.mysql.jdbc.Driver\r\n" + 
				"spring.datasource.username=root\r\n" + 
				"spring.datasource.password=root\r\n" + 
				"\r\n" + 
				"spring.datasource.initialization-mode=always\r\n" + 
				"\r\n" + 
				"################### Hibernate Configuration ##########################\r\n" + 
				"spring.jpa.properties.hibernate.format_sql=true\r\n" + 
				"logging.level.org.hibernate.type=trace\r\n" + 
				"spring.jpa.hibernate.ddl-auto=update\r\n" + 
				"spring.jpa.show-sql=true\r\n" + 
				"\r\n" + 
				"#security.user.name=admin\r\n" + 
				"#security.user.password=secret\r\n" + 
				"#security.user.role=USER,ADMIN\r\n" + 
				"");

		String newpath= "C://Users//djamel//Desktop//service1//src//main//resources//bootstrap.properties";

		text=buffer.toString();
		BufferedWriter output = null;
		try {
			File file = new File(newpath);
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
			output.flush();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( output != null ) {
				output.close();
			}
		}



	}






	// creatDataBase
	public static int creatDataBase(String databaseName){
		try {
			// String databaseName = "d";
			String userName = "root";
			String password = "root";

			String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
			connection = DriverManager.getConnection(url,userName, password);

			String sql = "CREATE DATABASE IF NOT EXISTS model_" + databaseName;

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			//	JOptionPane.showMessageDialog(null,databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	} 





	public static void createGitBooStrap(String name) throws IOException {
		String text = "Hello jimmi";
		//	newMkdirss(FinalName.pathPOM,name);
		newMkdirss("‪C:\\Users\\djamel\\cloud-conf\\msmodele.properties",name);

		StringBuffer buffer= new StringBuffer() ;
		buffer.append ("yParam=125\r\n" + 
				"me=djameljimmizerrouk@gmail.com\r\n" + 
				"");

		String newpath= "‪C:\\Users\\djamel\\cloud-conf\\service-"+name+".properties";

		text=buffer.toString();
		BufferedWriter output = null;
		try {
			File file = new File(newpath);
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
			output.flush();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( output != null ) {
				output.close();
			}
		}



	}

}
