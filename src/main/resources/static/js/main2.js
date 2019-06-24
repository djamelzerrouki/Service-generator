

$(document).ready(function(){
    $(' .nBtn, .table .eBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if(text=='Edit') {

            $.get(href, function (employe, status) {
                $('.myForm #id').val(employe.id);
                $('.myForm #name').val(employe.name);
                $('.myForm #password').val(employe.password);
                $('.myForm #tlphon').val(employe.tlphon);
              //  $('.myForm #mytask').val(employe.mytask);
            });

            $('.myForm #exampleModal').modal();
        }else{
        	 $('.myForm #id').val('');
             $('.myForm #name').val('');
             $('.myForm #password').val('');
             $('.myForm #tlphon').val('');
         //    $('.myForm #mytask').val('');
             $('.myForm #exampleModal').modal();
        }
    });

    $('.table .delBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href',href);
        $('#myModal').modal();
        });
});