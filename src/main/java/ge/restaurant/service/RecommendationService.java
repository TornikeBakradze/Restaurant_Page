package ge.restaurant.service;

import ge.restaurant.repository.RatingRepository;;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVStrategy;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.csv.CSVFormat.*;


@Service
public class RecommendationService {
    @Autowired
    private RatingRepository ratingRepository;
    private final String csvPath =
            "src\\main\\resources\\myFolder\\file.csv";

    public void createCsv() throws IOException {
        List<Object[]> objects = ratingRepository.allUserRating();

        CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(csvPath), CSVStrategy.DEFAULT_STRATEGY);
        // Write the data rows
        for (Object[] row : objects) {
            String[] rowData = {
                    String.valueOf(row[0]), // Restaurant ID
                    String.valueOf(row[1]), // User ID
                    String.valueOf(row[2])  // Average Rating
            };
            csvPrinter.println(rowData);
        }
        csvPrinter.flush();
        System.out.println("Data written to CSV file successfully.");
    }

    public List<Long> Recommendation(Long id) throws IOException {
        createCsv();
        List<Long> recommendedRestaurant=new ArrayList<>();
        try {
            DataModel datamodel = new FileDataModel(new File(csvPath)); //data


            UserSimilarity usersimilarity = new EuclideanDistanceSimilarity(datamodel);

            UserNeighborhood userneighborhood = new ThresholdUserNeighborhood(0.1, usersimilarity, datamodel);

            UserBasedRecommender recommender = new GenericUserBasedRecommender(datamodel, userneighborhood, usersimilarity);


            List<RecommendedItem> recommendations = recommender.recommend(id, 3);

            for (RecommendedItem recommendation : recommendations) {
                recommendedRestaurant.add(recommendation.getItemID());
            }
            for (RecommendedItem recommendation : recommendations) {
                System.out.println(recommendation);
            }

        } catch (Exception e) {
        }
        return recommendedRestaurant;
    }
}
