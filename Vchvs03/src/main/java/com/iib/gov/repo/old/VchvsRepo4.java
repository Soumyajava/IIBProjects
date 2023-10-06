package com.iib.gov.repo.old;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iib.gov.service.ClaimHistoryService;

@Repository
public interface VchvsRepo4 extends CrudRepository<com.iib.gov.entity.vchvsEntityOld.VchvsEntity4, String> {
	
//	@Query("from FruadEntity where input_inserted_date=:input_inserted_date and a_TXT_INSURER=:a_TXT_INSURER")
	
//	@Query(value="select * from IIW_MOT_PUBLIC_SEARCH_2021 with(nolock) where TXT_CHASSIS_NUMBER=:chassisno"
//			
//			,nativeQuery = true)
	
	  @Query(
			  value="SELECT DISTINCT CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
				  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,\r\n"
				  		+ "sum(ISNULL(TOTAL_TP_CLAIMS_PAID_AMOUNT,0)) TOTAL_TP_CLAIMS_PAID_AMOUNT,sum(ISNULL(TP_OPEN_PROVISION,0)) TP_OPEN_PROVISION,\r\n"
				  		+ "sum(ISNULL(TP_CLOSE_PROVISION,0)) TP_CLOSE_PROVISION,\r\n"
				  		+ "SUM(NUM_OD_LOSS_PAID+NUM_OD_EXPENSES_PAID) OD_CLAIMS_PAID,\r\n"
				  		+ "CASE WHEN MIN(CLAIM_STATUS)='1' THEN 'FULLY SETTLED'\r\n"
				  		+ "     WHEN MIN(CLAIM_STATUS)='2' THEN 'PARTIALLY SETTLED'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)='3' THEN 'REPUDIATED CLAIM'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)='4' THEN 'CLOSED WITHOUT PAYMENT'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)='5' THEN 'FULLY OUTSTANDING' END CLAIM_STATUS,CASE WHEN CLASS_CODE = '11' THEN 'PRIVATE CAR'\r\n"
				  		+ "     WHEN CLASS_CODE = '12' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  WITH 750 TO 1000CC)'\r\n"
				  		+ "	 WHEN CLASS_CODE = '13' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  LESS THAN 750 )'\r\n"
				  		+ "	 WHEN CLASS_CODE = '14' THEN 'TWO WHEELERS'\r\n"
				  		+ "	 WHEN CLASS_CODE = '15' THEN 'TWO WHEELERS WITH SIDE CAR'\r\n"
				  		+ "	 WHEN CLASS_CODE = '16' THEN 'THREE WHEELER INVALID CARRIAGE WITH SIDE CAR -TREATED AS TWO WHEELER'\r\n"
				  		+ "	 WHEN CLASS_CODE = '17' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PUBLIC'\r\n"
				  		+ "	 WHEN CLASS_CODE = '18' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PRIVATE'\r\n"
				  		+ "	 WHEN CLASS_CODE = '19' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND  PEDAL CYCLES - PUBLIC'\r\n"
				  		+ "	 WHEN CLASS_CODE = '20' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND PEDAL CYCLES - PRIVATE'\r\n"
				  		+ "	 WHEN CLASS_CODE = '21' THEN 'PASSENGER CARRYING  FOUR WHEELED VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '22' THEN 'PASSENGER CARRYING  MOTORISED THREE WHEELED VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '23' THEN 'SPECIAL TYPE OF VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '24' THEN 'TWO WHEELERS - HIRE OR REWARD'\r\n"
				  		+ "	 WHEN CLASS_CODE = '25' THEN 'MOTOR TRADE ROAD TRANSIT RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '26' THEN 'MOTOR TRADE ROAD RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '27' THEN 'MOTOR TRADE INTERNAL RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '28' THEN 'STANDALONE TRAILOR'\r\n"
				  		+ "	 WHEN CLASS_CODE = '29' THEN 'QUADRICYCLE (PVT. USE)'\r\n"
				  		+ "	 WHEN CLASS_CODE = '30' THEN 'QUADRICYCLE COMMERCIAL USE)' END CLASS_CODE\r\n"
				  		+ "FROM IIW_MOT_CLAIM_HISTORY_UAT WITH (NOLOCK)\r\n"
				  		+ "WHERE CHASSIS_NUMBER =:chassisno \r\n"
				  		+ "GROUP BY \r\n"
				  		+ "CLASS_CODE,CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
				  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,TOTAL_TP_CLAIMS_PAID_AMOUNT,TP_OPEN_PROVISION,TP_CLOSE_PROVISION" ,nativeQuery = true)
	public List<ClaimHistoryService> findByChassisno(String chassisno);
	
	  @Query(
			  value="SELECT DISTINCT CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
			  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,\r\n"
			  		+ "sum(ISNULL(TOTAL_TP_CLAIMS_PAID_AMOUNT,0)) TOTAL_TP_CLAIMS_PAID_AMOUNT,sum(ISNULL(TP_OPEN_PROVISION,0)) TP_OPEN_PROVISION,\r\n"
			  		+ "sum(ISNULL(TP_CLOSE_PROVISION,0)) TP_CLOSE_PROVISION,\r\n"
			  		+ "SUM(NUM_OD_LOSS_PAID+NUM_OD_EXPENSES_PAID) OD_CLAIMS_PAID,\r\n"
			  		+ "CASE WHEN MIN(CLAIM_STATUS)=1 THEN 'FULLY SETTLED'\r\n"
			  		+ "     WHEN MIN(CLAIM_STATUS)=2 THEN 'PARTIALLY SETTLED'\r\n"
			  		+ "	 WHEN MIN(CLAIM_STATUS)=3 THEN 'REPUDIATED CLAIM'\r\n"
			  		+ "	 WHEN MIN(CLAIM_STATUS)=4 THEN 'CLOSED WITHOUT PAYMENT'\r\n"
			  		+ "	 WHEN MIN(CLAIM_STATUS)=5 THEN 'FULLY OUTSTANDING' END CLAIM_STATUS,CASE WHEN CLASS_CODE = '11' THEN 'PRIVATE CAR'\r\n"
			  		+ "     WHEN CLASS_CODE = '12' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  WITH 750 TO 1000CC)'\r\n"
			  		+ "	 WHEN CLASS_CODE = '13' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  LESS THAN 750 )'\r\n"
			  		+ "	 WHEN CLASS_CODE = '14' THEN 'TWO WHEELERS'\r\n"
			  		+ "	 WHEN CLASS_CODE = '15' THEN 'TWO WHEELERS WITH SIDE CAR'\r\n"
			  		+ "	 WHEN CLASS_CODE = '16' THEN 'THREE WHEELER INVALID CARRIAGE WITH SIDE CAR -TREATED AS TWO WHEELER'\r\n"
			  		+ "	 WHEN CLASS_CODE = '17' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PUBLIC'\r\n"
			  		+ "	 WHEN CLASS_CODE = '18' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PRIVATE'\r\n"
			  		+ "	 WHEN CLASS_CODE = '19' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND  PEDAL CYCLES - PUBLIC'\r\n"
			  		+ "	 WHEN CLASS_CODE = '20' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND PEDAL CYCLES - PRIVATE'\r\n"
			  		+ "	 WHEN CLASS_CODE = '21' THEN 'PASSENGER CARRYING  FOUR WHEELED VEHICLES'\r\n"
			  		+ "	 WHEN CLASS_CODE = '22' THEN 'PASSENGER CARRYING  MOTORISED THREE WHEELED VEHICLES'\r\n"
			  		+ "	 WHEN CLASS_CODE = '23' THEN 'SPECIAL TYPE OF VEHICLES'\r\n"
			  		+ "	 WHEN CLASS_CODE = '24' THEN 'TWO WHEELERS - HIRE OR REWARD'\r\n"
			  		+ "	 WHEN CLASS_CODE = '25' THEN 'MOTOR TRADE ROAD TRANSIT RISK ONLY'\r\n"
			  		+ "	 WHEN CLASS_CODE = '26' THEN 'MOTOR TRADE ROAD RISK ONLY'\r\n"
			  		+ "	 WHEN CLASS_CODE = '27' THEN 'MOTOR TRADE INTERNAL RISK ONLY'\r\n"
			  		+ "	 WHEN CLASS_CODE = '28' THEN 'STANDALONE TRAILOR'\r\n"
			  		+ "	 WHEN CLASS_CODE = '29' THEN 'QUADRICYCLE (PVT. USE)'\r\n"
			  		+ "	 WHEN CLASS_CODE = '30' THEN 'QUADRICYCLE COMMERCIAL USE)' END CLASS_CODE\r\n"
			  		+ "FROM IIW_MOT_CLAIM_HISTORY_UAT WITH (NOLOCK)\r\n"
			  		+ "WHERE REG_NUMBER_VEHICLE =:regno \r\n"
			  		+ "GROUP BY \r\n"
			  		+ "CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
			  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,CASE WHEN CLASS_CODE = '11' THEN 'PRIVATE CAR'\r\n"
			  		+ "     WHEN CLASS_CODE = '12' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  WITH 750 TO 1000CC)'\r\n"
			  		+ "	 WHEN CLASS_CODE = '13' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  LESS THAN 750 )'\r\n"
			  		+ "	 WHEN CLASS_CODE = '14' THEN 'TWO WHEELERS'\r\n"
			  		+ "	 WHEN CLASS_CODE = '15' THEN 'TWO WHEELERS WITH SIDE CAR'\r\n"
			  		+ "	 WHEN CLASS_CODE = '16' THEN 'THREE WHEELER INVALID CARRIAGE WITH SIDE CAR -TREATED AS TWO WHEELER'\r\n"
			  		+ "	 WHEN CLASS_CODE = '17' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PUBLIC'\r\n"
			  		+ "	 WHEN CLASS_CODE = '18' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PRIVATE'\r\n"
			  		+ "	 WHEN CLASS_CODE = '19' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND  PEDAL CYCLES - PUBLIC'\r\n"
			  		+ "	 WHEN CLASS_CODE = '20' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND PEDAL CYCLES - PRIVATE'\r\n"
			  		+ "	 WHEN CLASS_CODE = '21' THEN 'PASSENGER CARRYING  FOUR WHEELED VEHICLES'\r\n"
			  		+ "	 WHEN CLASS_CODE = '22' THEN 'PASSENGER CARRYING  MOTORISED THREE WHEELED VEHICLES'\r\n"
			  		+ "	 WHEN CLASS_CODE = '23' THEN 'SPECIAL TYPE OF VEHICLES'\r\n"
			  		+ "	 WHEN CLASS_CODE = '24' THEN 'TWO WHEELERS - HIRE OR REWARD'\r\n"
			  		+ "	 WHEN CLASS_CODE = '25' THEN 'MOTOR TRADE ROAD TRANSIT RISK ONLY'\r\n"
			  		+ "	 WHEN CLASS_CODE = '26' THEN 'MOTOR TRADE ROAD RISK ONLY'\r\n"
			  		+ "	 WHEN CLASS_CODE = '27' THEN 'MOTOR TRADE INTERNAL RISK ONLY'\r\n"
			  		+ "	 WHEN CLASS_CODE = '28' THEN 'STANDALONE TRAILOR'\r\n"
			  		+ "	 WHEN CLASS_CODE = '29' THEN 'QUADRICYCLE (PVT. USE)'\r\n"
			  		+ "	 WHEN CLASS_CODE = '30' THEN 'QUADRICYCLE COMMERCIAL USE)' END ",nativeQuery = true)
	
	//  @Query("SELECT new com.iib.gov.service.ClaimHistoryServiceDto(a.reg_number_vehicle, a.chassis_number_vehicle,a.engine_number,a.insurer_name)  from IIW_MOT_CLAIM_HISTORY a   WHERE a.reg_number_vehicle = :regno")
	public List<ClaimHistoryService> findByRegno(String regno);
	  
//@Query(value="SELECT TOP 1 * FROM IIW_MOT_PUBLIC_SEARCH_2021 with(nolock) WHERE TXT_REG_NUMBER_VEHICLE=:regno AND TXT_CHASSIS_NUMBER=:chassisno ORDER BY POLICY_END_DATE desc" ,nativeQuery = true)
	  @Query(
			  value="SELECT DISTINCT CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
				  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,\r\n"
				  		+ "sum(ISNULL(TOTAL_TP_CLAIMS_PAID_AMOUNT,0)) TOTAL_TP_CLAIMS_PAID_AMOUNT,sum(ISNULL(TP_OPEN_PROVISION,0)) TP_OPEN_PROVISION,\r\n"
				  		+ "sum(ISNULL(TP_CLOSE_PROVISION,0)) TP_CLOSE_PROVISION,\r\n"
				  		+ "SUM(NUM_OD_LOSS_PAID+NUM_OD_EXPENSES_PAID) OD_CLAIMS_PAID,\r\n"
				  		+ "CASE WHEN MIN(CLAIM_STATUS)=1 THEN 'FULLY SETTLED'\r\n"
				  		+ "     WHEN MIN(CLAIM_STATUS)=2 THEN 'PARTIALLY SETTLED'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)=3 THEN 'REPUDIATED CLAIM'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)=4 THEN 'CLOSED WITHOUT PAYMENT'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)=5 THEN 'FULLY OUTSTANDING' END CLAIM_STATUS,CASE WHEN CLASS_CODE = '11' THEN 'PRIVATE CAR'\r\n"
				  		+ "     WHEN CLASS_CODE = '12' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  WITH 750 TO 1000CC)'\r\n"
				  		+ "	 WHEN CLASS_CODE = '13' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  LESS THAN 750 )'\r\n"
				  		+ "	 WHEN CLASS_CODE = '14' THEN 'TWO WHEELERS'\r\n"
				  		+ "	 WHEN CLASS_CODE = '15' THEN 'TWO WHEELERS WITH SIDE CAR'\r\n"
				  		+ "	 WHEN CLASS_CODE = '16' THEN 'THREE WHEELER INVALID CARRIAGE WITH SIDE CAR -TREATED AS TWO WHEELER'\r\n"
				  		+ "	 WHEN CLASS_CODE = '17' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PUBLIC'\r\n"
				  		+ "	 WHEN CLASS_CODE = '18' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PRIVATE'\r\n"
				  		+ "	 WHEN CLASS_CODE = '19' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND  PEDAL CYCLES - PUBLIC'\r\n"
				  		+ "	 WHEN CLASS_CODE = '20' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND PEDAL CYCLES - PRIVATE'\r\n"
				  		+ "	 WHEN CLASS_CODE = '21' THEN 'PASSENGER CARRYING  FOUR WHEELED VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '22' THEN 'PASSENGER CARRYING  MOTORISED THREE WHEELED VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '23' THEN 'SPECIAL TYPE OF VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '24' THEN 'TWO WHEELERS - HIRE OR REWARD'\r\n"
				  		+ "	 WHEN CLASS_CODE = '25' THEN 'MOTOR TRADE ROAD TRANSIT RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '26' THEN 'MOTOR TRADE ROAD RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '27' THEN 'MOTOR TRADE INTERNAL RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '28' THEN 'STANDALONE TRAILOR'\r\n"
				  		+ "	 WHEN CLASS_CODE = '29' THEN 'QUADRICYCLE (PVT. USE)'\r\n"
				  		+ "	 WHEN CLASS_CODE = '30' THEN 'QUADRICYCLE COMMERCIAL USE)' END CLASS_CODE\r\n"
				  		+ "FROM IIW_MOT_CLAIM_HISTORY_UAT WITH (NOLOCK)\r\n"
				  		+ "WHERE REG_NUMBER_VEHICLE =:regno or CHASSIS_NUMBER= :chassisno \r\n"
				  		+ "GROUP BY \r\n"
				  		+ "CLASS_CODE,CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
				  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,TOTAL_TP_CLAIMS_PAID_AMOUNT,TP_OPEN_PROVISION,TP_CLOSE_PROVISION" ,nativeQuery = true)
	public List<ClaimHistoryService> findByRegnoAndChassisno(String regno,String chassisno);

	  @Query(
			  value="SELECT DISTINCT CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
				  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,\r\n"
				  		+ "sum(ISNULL(TOTAL_TP_CLAIMS_PAID_AMOUNT,0)) TOTAL_TP_CLAIMS_PAID_AMOUNT,sum(ISNULL(TP_OPEN_PROVISION,0)) TP_OPEN_PROVISION,\r\n"
				  		+ "sum(ISNULL(TP_CLOSE_PROVISION,0)) TP_CLOSE_PROVISION,\r\n"
				  		+ "SUM(NUM_OD_LOSS_PAID+NUM_OD_EXPENSES_PAID) OD_CLAIMS_PAID,\r\n"
				  		+ "CASE WHEN MIN(CLAIM_STATUS)=1 THEN 'FULLY SETTLED'\r\n"
				  		+ "     WHEN MIN(CLAIM_STATUS)=2 THEN 'PARTIALLY SETTLED'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)=3 THEN 'REPUDIATED CLAIM'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)=4 THEN 'CLOSED WITHOUT PAYMENT'\r\n"
				  		+ "	 WHEN MIN(CLAIM_STATUS)=5 THEN 'FULLY OUTSTANDING' END CLAIM_STATUS,CASE WHEN CLASS_CODE = '11' THEN 'PRIVATE CAR'\r\n"
				  		+ "     WHEN CLASS_CODE = '12' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  WITH 750 TO 1000CC)'\r\n"
				  		+ "	 WHEN CLASS_CODE = '13' THEN 'PRIVATE CAR (ONLY  THREE WHEELERS  LESS THAN 750 )'\r\n"
				  		+ "	 WHEN CLASS_CODE = '14' THEN 'TWO WHEELERS'\r\n"
				  		+ "	 WHEN CLASS_CODE = '15' THEN 'TWO WHEELERS WITH SIDE CAR'\r\n"
				  		+ "	 WHEN CLASS_CODE = '16' THEN 'THREE WHEELER INVALID CARRIAGE WITH SIDE CAR -TREATED AS TWO WHEELER'\r\n"
				  		+ "	 WHEN CLASS_CODE = '17' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PUBLIC'\r\n"
				  		+ "	 WHEN CLASS_CODE = '18' THEN 'GOODS CARRYING VEHICLES OTHER THAN THREE WHEELERS - PRIVATE'\r\n"
				  		+ "	 WHEN CLASS_CODE = '19' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND  PEDAL CYCLES - PUBLIC'\r\n"
				  		+ "	 WHEN CLASS_CODE = '20' THEN 'GOODS CARRYING MOTORISED  THREE WHEELERS AND PEDAL CYCLES - PRIVATE'\r\n"
				  		+ "	 WHEN CLASS_CODE = '21' THEN 'PASSENGER CARRYING  FOUR WHEELED VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '22' THEN 'PASSENGER CARRYING  MOTORISED THREE WHEELED VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '23' THEN 'SPECIAL TYPE OF VEHICLES'\r\n"
				  		+ "	 WHEN CLASS_CODE = '24' THEN 'TWO WHEELERS - HIRE OR REWARD'\r\n"
				  		+ "	 WHEN CLASS_CODE = '25' THEN 'MOTOR TRADE ROAD TRANSIT RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '26' THEN 'MOTOR TRADE ROAD RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '27' THEN 'MOTOR TRADE INTERNAL RISK ONLY'\r\n"
				  		+ "	 WHEN CLASS_CODE = '28' THEN 'STANDALONE TRAILOR'\r\n"
				  		+ "	 WHEN CLASS_CODE = '29' THEN 'QUADRICYCLE (PVT. USE)'\r\n"
				  		+ "	 WHEN CLASS_CODE = '30' THEN 'QUADRICYCLE COMMERCIAL USE)' END CLASS_CODE\r\n"
				  		+ "FROM IIW_MOT_CLAIM_HISTORY_UAT WITH (NOLOCK)\r\n"
				  		+ "WHERE REG_NUMBER_VEHICLE IN (:regno1,:regno2) \r\n"
				  		+ "GROUP BY \r\n"
				  		+ "CLASS_CODE,CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
				  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,TOTAL_TP_CLAIMS_PAID_AMOUNT,TP_OPEN_PROVISION,TP_CLOSE_PROVISION" ,nativeQuery = true) 
	  
	  public List<ClaimHistoryService> basedOnDLRegnos(String regno1,String regno2);
}
