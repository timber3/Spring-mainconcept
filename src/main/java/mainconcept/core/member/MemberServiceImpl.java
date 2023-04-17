package mainconcept.core.member;

public class MemberServiceImpl implements MemberService{

    // 현재 이상태는 DIP를 위반하고 있다.
    // 그 이유로는 MemberServiceImpl 은 MemberRepository 인터페이스를 의존하고 있는데
    // 그 구현체인 MemoryMemberRepository 또한 의존하고 있기 때문에 DIP를 만족하지 않는다.
    // private final MemberRepository memberRepository = new MemoryMemberRepository();


    // 이렇게 바꿔주고 생성자를 통해서 인스턴스를 넣어주게 되면
    // 인터페이스에만 의존하게 되기 때문에 DIP를 만족 하게된다.
    // (생성자 주입)
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
