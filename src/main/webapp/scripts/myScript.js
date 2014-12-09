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
    formData .append("path", $("#pathStr").val());
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

function showFolderForm(){
    $("#createFolderSpan").show();

    $("#folderName").val("");
}

function createFolder(){
    if($("#folderName").val().length==0){
        return false;
    }
    _folderName= $("#folderName").val();
    _pathStr= $("#pathStr").val();
    $("#loadingGif").show();

    $.ajax({
        type: "POST",
        url: "ajax/createFolder",
        data: { pathStr: _pathStr, folderName: _folderName},
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

function openFolder(_folderName){
    $("#loadingGif").show();

    _path = ($("#pathStr").val().length>0 ? ($("#pathStr").val()+"/") : $("#pathStr").val()) + _folderName;

    $.ajax({
        type: "POST",
        url: "ajax/fileListing",
        data: { path: _path},
        success: function(resp){
            $("#listingContainer").html(resp);
            $("#loadingGif").hide();
        },error: function(resp){
            alert("Error!");
        }
        //dataType: dataType
    });
}

function downloadFile(_fileName){
    $("#loadingGif").show();

    _path = ($("#pathStr").val().length>0 ? ($("#pathStr").val()+"/") : $("#pathStr").val());

    window.location.href = "downloadFile?path=" + _path + "&fileName=" + _fileName;
}