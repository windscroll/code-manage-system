package com.code.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class TreeNode {
    private Integer id;
    private Integer parentId;
    private Integer nodeType;
    private String nodeName;
    private Date createTime;
    private List<TreeNode> children;
}