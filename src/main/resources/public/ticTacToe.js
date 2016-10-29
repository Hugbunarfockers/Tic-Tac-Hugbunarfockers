$(document).ready(function(){

   	$("#playBtn").click(function(){
        $("#board").removeClass("hidden");
        $("#players").addClass("hidden");
    });

    var thisId;
    $(".available").hover(
        function(){
            thisId = this.id;

            $(this).addClass("hoverClass");
        },
        function () {
            $(this).removeClass("hoverClass");
        }
    );
   
    $(".available").click(function(){
        if( $(this).hasClass("unavailable")){
            $("#occupied").removeClass("hidden");  
        }
        else{
            $(this).addClass("unavailable");
            $("#occupied").addClass("hidden");   
        } 
    });    
});