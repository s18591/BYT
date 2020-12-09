public class TicTacToe {

	//Encapsulate fields
	//Long method(Extract)

    private StringBuffer board;

    public TicTacToe(String s) {
        board = new StringBuffer(s);
    }

    public TicTacToe(String s, int position, char player) {
        setBoard(new StringBuffer(s));
        getBoard().setCharAt(position, player);
    }

    public int suggestMove(char player) {
        for (int i = 0; i < 9; i++) {
            if (getBoard().charAt(i) == '-') {
                TicTacToe game = makeMove(i, player);
                if (game.winner() == player)
                    return i;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (getBoard().charAt(i) == '-')
                return i;
        }

        return -1;
    }

    public TicTacToe makeMove(int i, char player) {
        return new TicTacToe(board.toString(), i, player);
    }

    public char winner() {
        // check for horizontal winner
		Character i1 = checkHorizontal();
		if (i1 != null) return i1;

		// check for vertical winner
		Character i = checkVertical();
		if (i != null) return i;

		// check for diagonal winner
		Character x = checkDiagonal();
		if (x != null) return x;

		// no winner yet
        return '-';
    }

	private Character checkDiagonal() {
		if (getBoard().charAt(0) != '-' && getBoard().charAt(4) == getBoard().charAt(0)
				&& getBoard().charAt(8) == getBoard().charAt(0))
			return getBoard().charAt(0);
		if (getBoard().charAt(2) != '-' && getBoard().charAt(4) == getBoard().charAt(2)
				&& getBoard().charAt(6) == getBoard().charAt(2))
			return getBoard().charAt(2);
		return null;
	}

	private Character checkVertical() {
		for (int i = 0; i < 3; ++i) {
			if (getBoard().charAt(i) != '-'
					&& getBoard().charAt(i + 3) == getBoard().charAt(i)
					&& getBoard().charAt(i + 6) == getBoard().charAt(i))
				return getBoard().charAt(i);
		}
		return null;
	}

	private Character checkHorizontal() {
		for (int i = 0; i < 9; i += 3) {
			if (getBoard().charAt(i) != '-'
					&& getBoard().charAt(i + 1) == getBoard().charAt(i)
					&& getBoard().charAt(i + 2) == getBoard().charAt(i))
				return getBoard().charAt(i);
		}
		return null;
	}

	public StringBuffer getBoard() {
        return board;
    }

    public void setBoard(StringBuffer board) {
        this.board = board;
    }
}
