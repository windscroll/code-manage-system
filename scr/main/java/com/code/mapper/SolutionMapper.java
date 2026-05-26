package com.code.mapper;

import com.code.entity.QuestionSolution;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SolutionMapper {
    List<QuestionSolution> getSolutionByNodeId(@Param("nodeId") Integer nodeId);
    void saveSolution(QuestionSolution solution);
    void deleteSolution(@Param("id") Integer id);
}