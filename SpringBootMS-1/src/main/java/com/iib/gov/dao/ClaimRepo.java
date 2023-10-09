package com.iib.gov.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iib.gov.entity.ClaimHistory;
import com.iib.gov.service.ClaimHistoryServiceProjection;


@Repository
public interface ClaimRepo extends CrudRepository<ClaimHistory, Integer> {
	
	
	
	/*
	 * @Query(
	 * value="select INSURER_CODE,REG_NUMBER_VEHICLE,CLAIM_NUMBER,TXT_CHILD_CLAIM_NUMBER,ACCIDENT_LOSS_DATE,\r\n"
	 * +
	 * "CLAIM_INTIMATION_DATE,CLAIM_TYPE,sum(NUM_OD_LOSS_PAID+NUM_OD_EXPENSES_PAID) as paid\r\n"
	 * + "from IIW_MOT_CLAIM_HISTORY with(nolock)\r\n" +
	 * "where REG_NUMBER_VEHICLE=:regno " +
	 * "group by INSURER_CODE,REG_NUMBER_VEHICLE,CLAIM_NUMBER,TXT_CHILD_CLAIM_NUMBER,ACCIDENT_LOSS_DATE,\r\n"
	 * + "CLAIM_INTIMATION_DATE,CLAIM_TYPE"
	 * 
	 * ,nativeQuery = true)
	 */
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
				  		+ "FROM IIW_MOT_CLAIM_HISTORY WITH (NOLOCK)\r\n"
				  		+ "WHERE REG_NUMBER_VEHICLE =:regno \r\n"
				  		+ "GROUP BY \r\n"
				  		+ "CLASS_CODE,CLAIM_NUMBER,REG_NUMBER_VEHICLE,CHASSIS_NUMBER,ENGINE_NUMBER,INSURER_NAME,CLAIM_TYPE,ACCIDENT_LOSS_DATE,\r\n"
				  		+ "CLAIM_INTIMATION_DATE,BOO_OD_TOTAL_LOSS,BOO_THEFT,TOTAL_TP_CLAIMS_PAID_AMOUNT,TP_OPEN_PROVISION,TP_CLOSE_PROVISION" 
			  
			  ,nativeQuery = true)

	public List<ClaimHistoryServiceProjection> getTotal(String regno);

}