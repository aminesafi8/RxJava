package tn.aminesafi.rxjava.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String userId;
    private Integer id;
    private String title;
    private Boolean completed;
}
