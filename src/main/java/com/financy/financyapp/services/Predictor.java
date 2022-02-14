package com.financy.financyapp.services;

import com.financy.financyapp.models.User;
import com.financy.financyapp.models.dto.PredictorData;

public interface Predictor {
    PredictorData getPredictedDataForUser(User user);
}
