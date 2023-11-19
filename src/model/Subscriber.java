package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Subscriber{
    private String id, name, ref;
}
