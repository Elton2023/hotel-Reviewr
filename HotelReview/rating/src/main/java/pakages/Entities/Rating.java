package pakages.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document("users_ratings")
public class Rating {
    @Id
    private String ratingId;
    private int rating;
    private String userId;
    private String hotelId;

    private String feedback;
}
