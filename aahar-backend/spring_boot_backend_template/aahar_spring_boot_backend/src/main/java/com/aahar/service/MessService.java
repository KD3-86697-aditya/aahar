package com.aahar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.MenuItemRespDTO;
import com.aahar.dtos.MessReqDTO;
import com.aahar.dtos.MessRespDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface MessService {
	
ApiResponse addMess(MessReqDTO mess);

ApiResponse updateMess(Long MesId,MessReqDTO mess);

List<MessRespDTO> getAllMesses();

ApiResponse  deleteMess(Long MessId);


public List<MessRespDTO> getMessesByCity(String city); // current user City

public List<MessRespDTO> searchMesses(String query);

//public List<MessRespDTO> filterMessesByMealType(MealType mealType);
public List<MenuItemRespDTO> getMenuItems(Long messId);
public MessRespDTO getMessDetails(Long messId);
}
