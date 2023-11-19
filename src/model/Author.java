package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Author {
    private String id, name;
    private Sex sex;
}
