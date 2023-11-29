package org.africalib.test.test.profile;

import org.africalib.test.test.entity.Profile;
import org.africalib.test.test.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() { //모든 프로필 가져오는 메소드
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id) { //주어진 id 프로필 가져오는 메소드
        return profileRepository.findById(id).orElse(null);
    }

    public Profile saveProfile(Profile profile) { //저장, 업데이트
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) { //주어진 ID 해당 프로필 삭제
        profileRepository.deleteById(id);
    }
}