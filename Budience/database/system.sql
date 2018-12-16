insert into perfor_data values ('혁오밴드', '인디음악', '차가워질 마음을 미리 녹이는 노래', '18/08/28', '37.555008', '126.922553', '18/08/28');
insert into perfor_data values ('댄스나잇', '댄스', '무더웠던 여름을 탈탈 털어버릴 군무', '18/08/28', '37.552329', '126.923351', '18/08/28');
insert into perfor_data values ('몽니', '발라드', '훌쩍 다가온 가을을 맞이할 노래', '18/08/28', '37.555901', '126.924251', '18/08/29');
insert into perfor_data values ('피아', '랩/힙합', '니가뭔데! 오늘 하루 상사에게 받은 상처, 랩으로 날리자', '18/08/28', '37.556995', '126.936439', '18/08/29');
insert into perfor_data values ('로펀', '클래식', '들뜬 내 하루를 마무리 시켜줄 잔잔한 클래식 메들리', '18/08/28', '37.556408', '126.936261', '18/08/29');
insert into perfor_data values ('매직나잇', '발라드', '그대의 마음은 안녕하신가요? 오늘 함께 힐링해요', '18/08/28', '37.556718', '126.936898', '18/08/29');
insert into perfor_data values ('버블버블', '댄스', '에세머들 모여라 SM하이라이트 특집', '18/08/28', '37.580528', '127.002885', '18/08/29');
insert into perfor_data values ('간증', '인디음악', '쌀쌀한 가을 밤, 내 마음을 달래줄 MUSIC', '18/08/28', '37.581723', '127.002836', '18/08/29');
insert into perfor_data values ('슈퍼비', '랩/힙합', '속에서 발버둥치는 힙합을 뽐내라! 프리랩 배틀', '18/08/28', '37.580830', '127.002562', '18/08/29');
insert into perfor_data values ('후즈마트', '클래식', '도심 속 지친 마음, 클래식으로 힐링하세요.', '18/08/28', '37.528737', '127.069742', '18/08/29');

insert into TEAM_DATA values ('슈퍼비', '멤버정보', '랩/힙합', '혜화', '속에서 발버둥치는 힙합을 뽐내라! 프리랩 배틀', 'youtube', 'sound', '공연1','공연2', '공연3', '공연4');
insert into TEAM_DATA values ('후즈마트', '멤버정보', '클래식', '뚝섬', '도심 속에 지친 당신, 클래식으로 힐링하세요.', 'youtube', 'sound', '공연1','공연2', '공연3', '공연4');

Update TEAM_DATA set JARNE='인디음악' where Teamname = '혁오밴드';
Update TEAM_DATA set JARNE='댄스' where Teamname = '댄스나잇';
Update TEAM_DATA set JARNE='발라드' where Teamname = '몽니';
Update TEAM_DATA set JARNE='랩/힙합' where Teamname = '피아';
Update TEAM_DATA set JARNE='클래식' where Teamname = '로펀';
Update TEAM_DATA set JARNE='발라드' where Teamname = '매직나잇';
Update TEAM_DATA set JARNE='댄스' where Teamname = '버블버블';
Update TEAM_DATA set JARNE='인디음악' where Teamname = '간증';
Update TEAM_DATA set JARNE='랩/힙합' where Teamname = '슈퍼비';
Update TEAM_DATA set JARNE='클래식' where Teamname = '후즈마트';

commit