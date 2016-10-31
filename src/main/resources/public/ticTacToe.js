$(document).ready(function(){
    var boardForm = $('#boardForm');
    var resetGame = $('#resetGame');
    var cell;
    var gameOver = false;

    $('#playBtn').attr('disabled', true);

    $('#playerForm').change(function(){
        var player1NameStatus = $('#player1name').val();
        var player1KeyStatus = $('#player1key').val();
        var player2NameStatus = $('#player2name').val();
        var player2KeyStatus = $('#player2key').val();

        if (!player1NameStatus || !player1KeyStatus
            || !player2NameStatus || !player2KeyStatus) {
            $('#playBtn').attr('disabled', true);
        }
        else {
            $('#playBtn').attr('disabled', false);
        }
    });

    // $('#playBtn').click(function(){
    //     $('#board').removeClass('hidden');
    //     $('#players').addClass('hidden');
    //     return false;
    // });

	var form = $('#playerForm');
    form.submit(function(event)
	{
        var p1name = $('#player1name').val();
        var p1key = $('#player1key').val();
		var p2name = $('#player2name').val();
		var p2key = $('#player2key').val();
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: 'player1name=' + p1name + '&player1key=' + p1key +
					'&player2name=' + p2name + '&player2key=' + p2key
        }).done(function(response) {
			$('#board').removeClass('hidden');
	        $('#players').addClass('hidden');
            $('#player1').html(p1name.toUpperCase() + ' = X');
            $('#player2').html(p2name.toUpperCase() + ' = O');
	        return false;
        }).fail(function() {
            console.log('Shit happened...');
            return false;
        });
        event.preventDefault();
    });

    var thisId;
    $('.available').hover(
        function(){
            thisId = this.id;

            $(this).addClass('hoverClass');
        },
        function () {
            $(this).removeClass('hoverClass');
        }
    );

    $('.available').click(function() {
        cell = $(this);
        if(!gameOver){
            boardForm.submit();
        }
    });

    boardForm.submit(function(event){
        var cellid = cell.attr('id');
        $.ajax({
            type: boardForm.attr('method'),
            url: boardForm.attr('action'),
            data: 'cell=' + cellid
        }).done(function(response, status, xhr) {
            console.log('Shit worked...');
            $(cell).html('<p class="center unselectable">' +
                            xhr.getResponseHeader('char') + '</p>');
            $(cell).addClass('unavailable');
            $('#occupied').addClass('hidden');
            var status = xhr.getResponseHeader('winner');
            if(status != null){
                gameOver = true;
                if(status == 'draw')
                {
                    $('#winnerIs').html('<p> ITS A DRAW !</p>');
                }
                else
                {
                    $('#winnerIs').html('<p> THE WINNER IS: ' + status + '!</p>');
                }
				//make a hidden button unhidden (that resets the game with)
				//make a hidden
                $('#resetButtons').removeClass('hidden');
            }
            return false;
        }).fail(function(response, status, xhr) {
            console.log('Shit happened...');
            $('#occupied').removeClass('hidden');
            return false;
        });
        event.preventDefault();
    });

    $('#resetPlayers').click(function() {
        location.reload();
    });

    resetGame.click(function() {
        $.ajax({
            type: resetGame.attr('method'),
            url: resetGame.attr('action'),
        }).done(function() {
            gameOver = false;
            $('#resetButtons').addClass('hidden');
            for(var i=1; i<10; i++){
                var cell = $('#cell'+i);
                cell.html('<p class="center unselectable"></p>');
                $(cell).removeClass('unavailable');
            }
            $('#winnerIs').html('');
        });
    });
});
