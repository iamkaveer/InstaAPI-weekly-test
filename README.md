# InstaAPI-weekly-test
Model :

User: : use authentication in here during sign in and sign up and use the token received for all user operation

private String firstName;

private String lastName;

private Integer age;

private String email;

private String phoneNumber;


Post:
private Integer postId;

private Timestamp createdDate;

private Timestamp updatedDate;

private String postData; (use any dummy string here ex "abcd" . this will be replaced by image link string in class)
@ManyToOne(fetch = FetchType.LAZY)
private User user;

AuthenticationToken :
private Long tokenId;

private String token
private LocalDate tokenCreationDate;


 @OneToOne
private 

User user  ;


For now create the basic API for use including authentication 

user controller : for now just do authentication at this point

sign in
sign up
update user details

Post Controller :

savePost
getPost
