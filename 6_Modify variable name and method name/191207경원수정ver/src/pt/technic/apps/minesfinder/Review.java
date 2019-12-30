package pt.technic.apps.minesfinder;

import javax.swing.JOptionPane;

import java.util.*;


public class Review extends javax.swing.JFrame {
    
	private Minefield minefield;
    private ButtonMinefield[][] buttons;
	
    public ArrayList<Integer> reviewMapClickedX = new ArrayList<>();
    public ArrayList<Integer> reviewMapClickedY = new ArrayList<>();
    public  static ArrayList<Integer> reviewMapMineX = new ArrayList<>();
	public  static ArrayList<Integer> reviewMapMineY = new ArrayList<>();
	public int reviewMapSizeX;
    public int reviewMapSizeY;
    public static int numOfMines=0;
    
    public int tmpCoordiX;
    public int tmpCoordiY;
    public int recNum=0;
    
    public void setSize(int x, int y) {
		reviewMapSizeX = x;
		reviewMapSizeY = y;
	}
    
    public void reviewMapClicked(int x, int y) {
		tmpCoordiX = x;
		tmpCoordiY = y;
		reviewMapClickedX.add(tmpCoordiX);
		reviewMapClickedY.add(tmpCoordiY);
		recNum++;
	}
    
    public void reviewUpdateButtonsStates() {
        for (int x = 0; x < reviewMapSizeX; x++) {
            for (int y = 0; y < reviewMapSizeY; y++) {
            	int rvstate = minefield.getGridState(x, y);
                buttons[x][y].setEstado(rvstate);
            }
        }
    }
  
    public void RecGameselectionDialog(){
        int reviewOption=JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "review the Last Game", JOptionPane.YES_NO_OPTION);
        
        if (reviewOption==JOptionPane.YES_OPTION) {
        	showRec1();
        }else if(reviewOption==JOptionPane.CLOSED_OPTION) {
        	 setVisible(false);
        }else if(reviewOption==JOptionPane.NO_OPTION) {
        	 setVisible(false);
        }
    }
    
	public void showRec1() {
			Minefield.isShow=1;
			
			for (int i=0;i<reviewMapSizeX;i++) {
				for (int j=0;j<reviewMapSizeY;j++) {
  					minefield.setMineCovered(i, j);
				}
			}
			
			reviewUpdateButtonsStates();
			
            JOptionPane.showMessageDialog(null, "���ݺ��� ���⸦ �����մϴ�. �� â�� �߸� space�ٸ� ���� ������ �ּ���",
                    "����", JOptionPane.INFORMATION_MESSAGE);
			recNum=reviewMapClickedX.size();

			ShowRec2(reviewMapSizeX,reviewMapSizeY,recNum,reviewMapClickedX,reviewMapClickedY);

		}
    
    
	   public void ShowRec2(int recSizeX,int recSizeY,int recNum, ArrayList<Integer> reclickX, ArrayList <Integer> reclickY ){
		   	
		   for (int i=0;i<recNum;i++) {
				
				int x=reviewMapClickedX.get(i);
				int y=reviewMapClickedY.get(i);
				
				minefield.revealGrid(x, y);
				

				reviewUpdateButtonsStates();
                
				JOptionPane.showMessageDialog(null,i+"��°\n \"�� â�� �߸�\" space�ٸ� ���� �������ּ���",
		                   "����", JOptionPane.INFORMATION_MESSAGE);
			}
				JOptionPane.showMessageDialog(null,"���Ⱑ �Ϸ�Ǿ����ϴ�",
	                   "����", JOptionPane.INFORMATION_MESSAGE);
				
				Minefield.isShow=0;
				
	    }
	    
	   public Review(Minefield minefield,ButtonMinefield[][] buttons) {
		   this.minefield = minefield;
		   this.buttons = buttons;
		   
	   }
}
