package model;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private String id, bookName;
    private Date releaseDate;
    private Author author;
    private int pageNumbers;
    private List<Topic> topics;
}