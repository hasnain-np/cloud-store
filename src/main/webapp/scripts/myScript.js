/**
 * Created by Hasnain on 12/7/2014.
 */

$(function() {
    $('.list').click(function() {
        $(this).addClass('listActive').siblings().removeClass('listActive');
    });

    $('#upFile').on("change", function(){
        if(this.files.length>0) {
            $("#startUpBtn").show();
            $("#selFileBtn").hide();
        }else{
            $("#startUpBtn").show();
            $("#selFileBtn").hide();
        }
    });

});


function selectFile(){
    $("#upFile").click();
}

function uploadFile(){
    if(upFile.files.length==0) {
        $("#startUpBtn").show();
        $("#selFileBtn").hide();
        $("#upFile").click();
        return false;
    }

    $("#loadingGif").show();

    var formData  = new FormData();
    formData .append("file", upFile.files[0]);

    $.ajax({
        type: "POST",
        url: "ajax/file",
        data: formData,
        processData: false,
        contentType: false,
        success: function(resp){
            $("#listingContainer").html(resp);
            $("#loadingGif").hide();
            $("#startUpBtn").hide();
            $("#selFileBtn").show();
            //alert("Success!");
        },error: function(resp){
            alert("Error!");
        }
        //dataType: dataType
    });
}