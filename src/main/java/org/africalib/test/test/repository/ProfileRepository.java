package org.africalib.test.test.repository;

import org.africalib.test.test.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // 추가적인 메서드가 필요하다면 여기에 선언할 수 있습니다.
}
