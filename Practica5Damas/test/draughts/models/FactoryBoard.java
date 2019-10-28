package draughts.models;

class FactoryBoard {
    
    enum BoardType {
        BOARD_INITIAL,
        BOARD_WHITE_BLOCK,
        BOARD_BLACK_BLOCK,
        BOARD_DRAW,
        BOARD_WHITE_PAWN_TO_DAMA,
        BOARD_BLACK_PAWN_TO_DAMA
    }
    
    Board get(BoardType type) {
        return new Board();
    }
}
