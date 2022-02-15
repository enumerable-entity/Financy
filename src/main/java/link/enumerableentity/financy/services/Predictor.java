package link.enumerableentity.financy.services;

import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.PredictorData;

public interface Predictor {
    PredictorData getPredictedDataForUser(User user);
}
