package com.group20.oop_project_group20_book_fair.Ataur;

public class Parking {
    private String carownername,carnumber,cartypecb,cardatamatchornotshow,staticlabel;

    public Parking(String carownername, String carnumber, String cartypecb) {
        this.carownername = carownername;
        this.carnumber = carnumber;
        this.cartypecb = cartypecb;
        this.cardatamatchornotshow = cardatamatchornotshow;
        this.staticlabel = staticlabel;
    }

    public String getCarownername() {
        return carownername;
    }

    public void setCarownername(String carownername) {
        this.carownername = carownername;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getCartypecb() {
        return cartypecb;
    }

    public void setCartypecb(String cartypecb) {
        this.cartypecb = cartypecb;
    }

    public String getCardatamatchornotshow() {
        return cardatamatchornotshow;
    }

    public void setCardatamatchornotshow(String cardatamatchornotshow) {
        this.cardatamatchornotshow = cardatamatchornotshow;
    }

    public String getStaticlabel() {
        return staticlabel;
    }

    public void setStaticlabel(String staticlabel) {
        this.staticlabel = staticlabel;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "carownername='" + carownername + '\'' +
                ", carnumber='" + carnumber + '\'' +
                ", cartypecb='" + cartypecb + '\'' +
                ", cardatamatchornotshow='" + cardatamatchornotshow + '\'' +
                ", staticlabel='" + staticlabel + '\'' +
                '}';
    }

    public void setExited(boolean b) {

    }

    public boolean isExited() {
        return false;
    }
}
