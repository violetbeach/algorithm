package kakao;

// 스킬트리
// Set에 String을 잘라서 넣을 때는 split을 쓰고 Arrays.asList로 리스트로 변환해주면 된다.
// Set에 String을 넣어도 contains로 비교가 가능하다.

public class SkillTree {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees) {
            String[] split = skill_tree.split("");
            int level = 0;
            for(int i=0; i<split.length; i++) {
                if(split[i].equals(skill.substring(level, level + 1))) {
                    level++;
                    if(level == skill.length()) {
                    	answer++;
                    	break;
                    }
                } else if(skill.contains(split[i])) {
                    break;
                }
                if(i == split.length-1) answer++;
            }
        }
        
        return answer;
    }
	
	public static void main(String[] args) {	
		SkillTree a = new SkillTree();
		String[] bb = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(a.solution("CBD", bb));	
	}

}
