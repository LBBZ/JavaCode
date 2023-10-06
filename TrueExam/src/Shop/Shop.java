package Shop;

import Adm.Admin.Schedule;
import Adm.Movie.Movie;
import Adm.Seat;

public class Shop {//购物车类，储存用户购买的票
    private Movie movie ;
    private Schedule schedule ;
    private int index ;
    private Seat seat;
    private int row;
    private int col;
    private double fee;

    public double getFee() {
        return fee;
    }

    public Shop(Movie movie, Schedule schedule, int index, Seat seat, int row, int col, double fee) {
        this.movie = movie;
        this.schedule = schedule;
        this.seat = seat;
        this.row = row;
        this.col = col;
        this.fee =fee;
        this.index=index;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
