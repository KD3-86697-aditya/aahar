package com.aahar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.MenuItemRespDTO;
import com.aahar.dtos.MessReqDTO;
import com.aahar.dtos.MessRespDTO;
import com.aahar.dtos.MessUpdateRequest;
import com.aahar.dtos.MessUpdateResponse;
import com.aahar.pojos.Mess;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface MessService {
	
ApiResponse addMess(MessReqDTO mess);

ApiResponse updateMess(Long MesId,MessReqDTO mess);

List<MessRespDTO> getAllMesses();

ApiResponse  deleteMess(Long MessId);

public Mess getMessDetails(Long messId);

public Mess updateMessDetails(Long messId, MessUpdateRequest request);


//-- ankush-end code
public List<MessRespDTO> getMessesByCity(String city); // current user City

public List<MessRespDTO> searchMesses(String query);

//public List<MessRespDTO> filterMessesByMealType(MealType mealType);
public List<MenuItemRespDTO> getMenuItems(Long messId);
public MessRespDTO getMessDetailsForUser(Long messId);




}
