package Entity;


@Getter
@Setter

public class Coursedto {
	private Integer id;
	private String name;
	Set<String> students = new HashSet<>();

}
