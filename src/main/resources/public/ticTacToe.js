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

	var form = $('#playerForm');
    form.submit(function( event )
	{
        var p1name = $("#player1name").val();
        var p1key = $("#player1key").val();
		var p2name = $("#player2name").val();
		var p2key = $("#player2key").val();
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: 'player1name=' + p1name + '&player1key=' + p1key +
					'&player2name=' + p2name + '&player2key=' + p2key
        }).done(function() {
			$("#board").removeClass("hidden");
	        $("#players").addClass("hidden");
	        return false;
        }).fail(function() {
            //$('#results').html('Unable to set name...').attr('class', 'alert alert-danger');
        });
        event.preventDefault();
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
