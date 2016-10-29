$(document).ready(function(){

    $("#playBtn").attr('disabled', true);

    $("#playerForm").change(function(){
        var player1NameStatus = $("#player1name").val();
        var player1KeyStatus = $("#player1key").val();
        var player2NameStatus = $("#player2name").val();
        var player2KeyStatus = $("#player2key").val();

        if (!player1NameStatus || !player1KeyStatus
            || !player2NameStatus || !player2KeyStatus) {
            $("#playBtn").attr('disabled', true);
        }
        else {
            $("#playBtn").attr('disabled', false);
        }
    });

    $("#playBtn").click(function(){
        $("#board").removeClass("hidden");
        $("#players").addClass("hidden");
        return false;
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
