import java.util.*;

public class RecommendationRunner implements Recommender {
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> itemIds = new ArrayList<String>();
        // Get movies released during or after 2010
        int year = 2010;
        YearAfterFilter yearAfterFilter = new YearAfterFilter(year);
        ArrayList<String> movies = MovieDatabase.filterBy(yearAfterFilter);
        // Only choose 20 items
        for (int i = 0; i < 20; i++) {
            itemIds.add(movies.get(i));
        }
        return itemIds;
    }
    
    public void printRecommendationsFor(String webRaterID) {
        // Initialize
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FourthRatings fourthRatings = new FourthRatings();
        MovieDatabase movie = new MovieDatabase();
        RaterDatabase rater = new RaterDatabase();
        movie.initialize(moviefile);
        rater.initialize(ratingsfile);
        
        // Get recommendations
        int numSimilarRaters = 10;
        int minimalRaters = 5;
        AllFilters filters = new AllFilters();
        filters.addFilter(new GenreFilter("Romance"));
        filters.addFilter(new MinutesFilter(80, 160));
        ArrayList<Rating> allRecommendations = fourthRatings.getSimilarRatingsByFilter(webRaterID, numSimilarRaters, minimalRaters, filters);
        ArrayList<Rating> topRecommendations = new ArrayList<Rating>();
        for (int i = 0; i < 10; i++) {
            if (i == allRecommendations.size()) {
                break;
            }
            topRecommendations.add(allRecommendations.get(i));
        }
        
        if (topRecommendations.isEmpty()) {
            System.out.println("I'm sorry, no recommendations found");
        } else {
            for (int i = 0; i < topRecommendations.size(); i++) {
                Rating item = topRecommendations.get(i);
                String itemId = item.getItem();
                String title = movie.getTitle(itemId);
                String genres = movie.getGenres(itemId);
                String directors = movie.getDirector(itemId);
                System.out.println(i + 1 + ". " + title + " | ");
                System.out.println("\tGenre(s): " + genres + " | ");
                System.out.println("\tDirector(s): " + directors);
            }
        }
    }
}