package entity;

import javax.persistence.*;

/**
 * Created by icebotari on 10/9/2017.
 */
@Entity
@Table(name = "dance")
public class Dance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "manId")
    private Man man;

    @ManyToOne
    @JoinColumn(name = "womanId")
    private Woman woman;

    @Column(name = "style")
    private String style;

    public Dance(){

    }

    public Dance(Man man, Woman woman, String style){
        this.man = man;
        this.woman = woman;
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public Man getManId() {
        return man;
    }

    public Woman getWomanId() {
        return woman;
    }

    public String getStyle() {
        return style;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManId(Man manId) {
        this.man = manId;
    }

    public void setWomanId(int womanId) {
        this.woman = woman;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
