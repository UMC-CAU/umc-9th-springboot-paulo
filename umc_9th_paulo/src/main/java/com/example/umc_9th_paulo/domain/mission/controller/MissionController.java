package com.example.umc_9th_paulo.domain.mission.controller;

import com.example.umc_9th_paulo.domain.mission.dto.MissionRequestDto;
import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/users/{userId}")
    public Page<MissionResponseDto.MissionUserDto> getMissionUser(@PathVariable Long userId, @RequestParam("finished") Boolean finished,
                                                                  @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        return missionService.MissionUserInfo(userId, finished, pageable);
    }

    @GetMapping("/regions/{regionName}/finished")
    public MissionResponseDto.MissionRegionDto countMissionRegion(@PathVariable String regionName,
                                                                  @RequestParam Long userId) {
        return missionService.getRegionMission(regionName, userId);
    }

    @GetMapping("/regions/{regionName}")
    public Page<MissionResponseDto.MissionRegionCanDto> regionCanDto(@PathVariable String regionName,
                                                                     @RequestParam Long userId,
                                                                     @PageableDefault(size = 10, sort = "remainingDuration") Pageable pageable) {
        return missionService.getRegionMissionCanDo(regionName, userId, pageable);
    }
}
