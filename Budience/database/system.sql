insert into perfor_data values ('�������', '�ε�����', '�������� ������ �̸� ���̴� �뷡', '18/08/28', '37.555008', '126.922553', '18/08/28');
insert into perfor_data values ('������', '��', '�������� ������ ŻŻ �о���� ����', '18/08/28', '37.552329', '126.923351', '18/08/28');
insert into perfor_data values ('����', '�߶��', '��½ �ٰ��� ������ ������ �뷡', '18/08/28', '37.555901', '126.924251', '18/08/29');
insert into perfor_data values ('�Ǿ�', '��/����', '�ϰ�����! ���� �Ϸ� ��翡�� ���� ��ó, ������ ������', '18/08/28', '37.556995', '126.936439', '18/08/29');
insert into perfor_data values ('����', 'Ŭ����', '��� �� �Ϸ縦 ������ ������ ������ Ŭ���� �޵鸮', '18/08/28', '37.556408', '126.936261', '18/08/29');
insert into perfor_data values ('��������', '�߶��', '�״��� ������ �ȳ��ϽŰ���? ���� �Բ� �����ؿ�', '18/08/28', '37.556718', '126.936898', '18/08/29');
insert into perfor_data values ('�������', '��', '�����ӵ� �𿩶� SM���̶���Ʈ Ư��', '18/08/28', '37.580528', '127.002885', '18/08/29');
insert into perfor_data values ('����', '�ε�����', '�ҽ��� ���� ��, �� ������ �޷��� MUSIC', '18/08/28', '37.581723', '127.002836', '18/08/29');
insert into perfor_data values ('���ۺ�', '��/����', '�ӿ��� �߹���ġ�� ������ �˳���! ������ ��Ʋ', '18/08/28', '37.580830', '127.002562', '18/08/29');
insert into perfor_data values ('���Ʈ', 'Ŭ����', '���� �� ��ģ ����, Ŭ�������� �����ϼ���.', '18/08/28', '37.528737', '127.069742', '18/08/29');

insert into TEAM_DATA values ('���ۺ�', '�������', '��/����', '��ȭ', '�ӿ��� �߹���ġ�� ������ �˳���! ������ ��Ʋ', 'youtube', 'sound', '����1','����2', '����3', '����4');
insert into TEAM_DATA values ('���Ʈ', '�������', 'Ŭ����', '�Ҽ�', '���� �ӿ� ��ģ ���, Ŭ�������� �����ϼ���.', 'youtube', 'sound', '����1','����2', '����3', '����4');

Update TEAM_DATA set JARNE='�ε�����' where Teamname = '�������';
Update TEAM_DATA set JARNE='��' where Teamname = '������';
Update TEAM_DATA set JARNE='�߶��' where Teamname = '����';
Update TEAM_DATA set JARNE='��/����' where Teamname = '�Ǿ�';
Update TEAM_DATA set JARNE='Ŭ����' where Teamname = '����';
Update TEAM_DATA set JARNE='�߶��' where Teamname = '��������';
Update TEAM_DATA set JARNE='��' where Teamname = '�������';
Update TEAM_DATA set JARNE='�ε�����' where Teamname = '����';
Update TEAM_DATA set JARNE='��/����' where Teamname = '���ۺ�';
Update TEAM_DATA set JARNE='Ŭ����' where Teamname = '���Ʈ';

commit