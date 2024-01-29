package org.Toy.Repository;

import org.Toy.Domain.Reply_comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply_comment, Long> {
}
