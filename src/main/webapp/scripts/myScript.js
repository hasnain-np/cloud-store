/**
 * Created by Hasnain on 12/7/2014.
 */

var rowDiv=null;
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
    upFile = $("#upFile")[0];
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

    console.log($("#pathStr").val());
    console.log(upFile.files[0]);

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
    $("#selectedRowName").val(_folderName);

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
    $("#selectedRowName").val(_fileName);

    _path = ($("#pathStr").val().length>0 ? ($("#pathStr").val()+"/") : $("#pathStr").val());

    window.location.href = "downloadFile?path=" + _path + "&fileName=" + _fileName;
    $("#loadingGif").hide();
}


function selectRow(rowVal, rowObj){
    rowDiv = rowObj;
    $("#selectedRowName").val(rowVal);
}

function deleteFile(){
    if($("#selectedRowName").val().length==0){
        return false;
    }
    _name= $("#selectedRowName").val();
    _pathStr= $("#pathStr").val();
    $("#loadingGif").show();

    $.ajax({
        type: "POST",
        url: "ajax/delete",
        data: { pathStr: _pathStr, name: _name},
        success: function(resp){
            if(resp.statusCode==0){
                alert(resp.statusText);
            }else{
                //delete succuessful
                rowDiv.parentNode.removeChild(rowDiv);
            }
            $("#loadingGif").hide();
            $("#startUpBtn").hide();
            $("#selFileBtn").show();
            //alert("Success!");
        },error: function(resp){
            alert("Error! Directory is not empty!");
        }
        //dataType: dataType
    });
}