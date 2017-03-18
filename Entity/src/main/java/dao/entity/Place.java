package dao.entity;

import javax.persistence.*;

@Entity
@Table
public class Place {
    private int place_id;
    private String addres;
    private String fotoPath;



    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id")
    public int getPlace_id() {return place_id;}
    @Column(name = "adress")
    public String getAddres() {
        return addres;
    }

    @Column(name = "foto")
    public String getFotoPath() {
        return fotoPath;
    }


    public Place() {
    }

    @ManyToOne
    private User user;

    @ManyToOne
    private Comment comment;


}
