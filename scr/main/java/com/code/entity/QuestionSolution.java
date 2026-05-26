package com.code.entity;

import lombok.Data;

@Data
public class QuestionSolution {
    private Integer id;
    private Integer nodeId;
    private Integer solveSort;
    private String langTag;
    private String solutionDesc;
    private String codeContent;
}