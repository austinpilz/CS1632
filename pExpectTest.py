import pexpect
import threading
import sys
import time

placement_list = ["A:1","A:5","B:1","B:4","C:1","C:3","D:1","D:3","E:1","E:2"]
ship_list = ["Battleship\r\n", "Carrier\r\n", "Cruiser\r\n", "Submarine\r\n", "Destroyer\r\n"]
start_coordinate = ["5\r\n","4\r\n", "3\r\n", "3\r\n", "2\r\n"]


def spawn_c1_thread():
	output = ""
    placementCounter = 0
    shipCounter = 0
	client = pexpect.spawn('java -jar dist/Client/BattleshipClient.jar')
	i = 0
    #In client 1 spawn

	#placing loop
	while placementCounter < 10:
		client.expect(start_coordinate[shipCounter])
		output+=client.before
		output+=client.after
		client.sendline(placement_list[placementCounter])
		client.expect(ship_list[shipCounter])
		output+=client.before
		output+=client.after
		placementCounter+=1
		client.sendline(placement_list[placementCounter])
		placementCounter+=1
		shipCounter+=1

	client.expect('!\r\n')
	output+=client.before
	output+=client.after
	
	client.expect('999\r\n')
	client.sendline('A:1')
	output+=client.before
	output+=client.after
	
	client.expect('999\r\n')
	client.sendline('A:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('A:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('A:4')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('A:5')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:4')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('C:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('C:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('C:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('D:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('D:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('D:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('E:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('E:2')
	output+=client.before
	output+=client.after

	client.expect('!\r\n')	
	output+=client.before
	output+=client.after


	client.close()

def spawn_c2_thread():

	output = ""
	client = pexpect.spawn('java -jar dist/Client/BattleshipClient.jar')
	time.sleep(5)
	placementCounter = 0
	shipCounter = 0
	i = 0
    #in client 2 spawn

	#placing loop
	while placementCounter < 10:
		client.expect(start_coordinate[shipCounter])
		output+=client.before
		output+=client.after
		client.sendline(placement_list[placementCounter])
		client.expect(ship_list[shipCounter])
		output+=client.before
		output+=client.after
		placementCounter+=1
		client.sendline(placement_list[placementCounter])
		placementCounter+=1
		shipCounter+=1

	client.expect('!\r\n')
	output+=client.before
	output+=client.after
	
	client.expect('999\r\n')
	client.sendline('A:1')
	output+=client.before
	output+=client.after
	
	client.expect('999\r\n')
	client.sendline('A:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('A:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('A:4')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('A:5')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('B:4')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('C:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('C:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('C:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('D:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('D:2')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('D:3')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('E:1')
	output+=client.before
	output+=client.after

	client.expect('999\r\n')	
	client.sendline('E:2')
	output+=client.before
	output+=client.after

	client.expect('')
	client.close()
	
def main():
	client1 = threading.Thread(target=spawn_c1_thread)
	time.sleep(5)
	client2 = threading.Thread(target=spawn_c2_thread)

	client1.start()
	client2.start()
	client1.join()
	client2.join()




if __name__ == '__main__':
    main()
	#spawn_c1_thread()
