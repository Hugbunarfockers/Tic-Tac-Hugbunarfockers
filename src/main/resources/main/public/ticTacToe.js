$(document).ready(function(){

   	$("#playBtn").click(function(){
        $("#board").removeClass("hidden");
        $("#players").addClass("hidden");
    });

   	
   	$("#cell1").mouseenter(function(){
   		$("#cell1").addClass("hoverClass");
   	});	
   	
	$("#cell1").mouseleave(function(){
   		$("#cell1").removeClass("hoverClass");
   	});

 



});