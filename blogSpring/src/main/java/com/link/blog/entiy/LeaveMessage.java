package com.link.blog.entiy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
  * @apiNote 用户留言记录的实体化
  * @author dl-nest
  * @date 2021/11/24 18:49
 */
@Entity
@Table(name = "blog_Message")
@Setter
@Getter
public class LeaveMessage {

    @Id
    private Integer mesId;

    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", updatable = false)
    private User uid;



}
