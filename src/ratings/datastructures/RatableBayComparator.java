package ratings.datastructures;

import ratings.Ratable;

public class RatableBayComparator extends Comparator<Ratable> {
        @Override
        public boolean compare(Ratable a, Ratable b) {
            return a.bayesianAverageRating(2,3) > b.bayesianAverageRating(2,3);
        }


}
