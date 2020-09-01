package main.lesson01BasicProcedures;

public class Field {
    private Move firstUserMove;
    private Move secondUserMove;

    public Move getFirstUserMove() {
        return firstUserMove;
    }

    public void setFirstUserMove(Move firstUserMove) {
        this.firstUserMove = firstUserMove;
    }

    public Move getSecondUserMove() {
        return secondUserMove;
    }

    public void setSecondUserMove(Move secondUserMove) {
        this.secondUserMove = secondUserMove;
    }
}
