package com.ssafy.tripApp.area.sido.dto;

import com.ssafy.tripApp.member.dto.MemberDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "SidoDto: 시도 정보", description = "한국의 전체 시도 정보를 나타낸다")
public class SidoDto {
	@ApiModelProperty(value = "시도 코드")
	private String sido_code;
	@ApiModelProperty(value = "시도 이름")
	private String sido_name;
}
