package dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMMENT")
public class Comment {
    private String whoWrite;
    private String text;
    private Date date;
    private int id;

    public void setWhoWrite(String whoWrite) {
        this.whoWrite = whoWrite;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    public int getId() {
        return id;
    }



    @Column(name = "who_write")
    public String getWhoWrite() {
        return whoWrite;
    }
    @Column(name = "text")
    public String getText() {
        return text;
    }
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public Comment() {

    }

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "comment")
    @JoinTable(name = "place_comment",joinColumns = @JoinColumn(name = "comment_id"),inverseJoinColumns = @JoinColumn(name = "place_id"))
    private Set<Place> commentPlaceList = new HashSet<>();
}
