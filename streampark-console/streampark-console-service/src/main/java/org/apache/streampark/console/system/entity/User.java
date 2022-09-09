/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.streampark.console.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = -4852732617765810959L;
    /**
     * user status
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_AVATAR = "default.jpg";

    public static final String SEX_MALE = "0";

    public static final String SEX_FEMALE = "1";

    public static final String SEX_UNKNOW = "2";

    public static final String DEFAULT_PASSWORD = "streampark666";

    @TableId(type = IdType.AUTO)
    private Long userId;

    @Size(min = 4, max = 20, message = "{range}")
    private String username;

    private String password;

    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    private String email;

    @NotBlank(message = "{required}")
    private String status;

    private Date createTime;

    private Date modifyTime;

    private Date lastLoginTime;

    @NotBlank(message = "{required}")
    private String sex;

    @Size(max = 100, message = "{noMoreThan}")
    private String description;

    private String avatar;

    @NotBlank(message = "{required}")
    private transient String roleId;

    private transient String roleName;

    private transient String sortField;

    private transient String sortOrder;

    private transient String createTimeFrom;
    private transient String createTimeTo;

    private transient String id;

    private String salt;

    private String nickName;

    /**
     * shiro-redis v3.1.0 must have getAuthCacheKey() or getId() function # Principal id field name.
     * The field which you can get unique id to identify this principal. # For example, if you use UserInfo as
     * Principal class, the id field maybe userId, userName, email, etc. # Remember to add getter to
     * this id field. For example, getUserId(), getUserName(), getEmail(), etc. # Default value is
     * authCacheKey or id, that means your principal object has a method called "getAuthCacheKey()" or
     * "getId()"
     *
     * @return userId as Principal id field name
     */
    public Long getAuthCacheKey() {
        return userId;
    }
}
