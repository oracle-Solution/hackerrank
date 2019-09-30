package riotgames;

import java.util.*;
    
    public class Challenge3 {
    
        public static void main(String[] args) {
            IsPlanValid();
        }
    
        public static void IsPlanValid() {
            Scanner in = new Scanner(System.in);
            String[] arr = in.nextLine().split(",");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            String C = "C", D = "D", F = "F", E = "E", B = "B", W = "W";
    
            Map<String, Integer> map = new HashMap<>();
            map.put(C, 1);map.put(D, 2);map.put(E, 3);map.put(F, 4);map.put(W, -1);
    
            Map<Integer, String> reverseMap = new HashMap<>();
            reverseMap.put(1, C);reverseMap.put(2, D);reverseMap.put(3, E);reverseMap.put(4, F);reverseMap.put(0, B);reverseMap.put(-1, W);
    
            int[][] garden = new int[n][m];
            Stack<Integer> stack = new Stack<>();
            String pickUp = "Pick Up";
    
            Set<String> flowers = new HashSet<>();
            flowers.add(C);flowers.add(D);flowers.add(F);flowers.add(E);
    
            while(in.hasNextLine()) {
                String input = in.nextLine();
                String[] args = input.split(",");
                if(args.length == 3) {
                    //assuming the garden composition is going to be correct
                    String flowerType = args[0];
                    int x = Integer.parseInt(args[1]);
                    int y = Integer.parseInt(args[2]);
    
                    if(garden[x][y] != 0) {
                        System.out.println("false");
                        printGarden(garden, n, m, reverseMap);
                        return;
                    }
    
                    garden[x][y] = map.get(flowerType);
    
                } else {
                    int plantType = map.get(args[1]);
                    int x = Integer.parseInt(args[2]), y = Integer.parseInt(args[3]);
                    if(pickUp.equalsIgnoreCase(args[0])) {
                        if(plantType != garden[x][y] || garden[x][y] == -1) {
                            System.out.println("false");
                            printGarden(garden, n, m, reverseMap);
                            return;
                        } else {
                            stack.push(garden[x][y]);
                            garden[x][y] = 0;
                        }
                    } else {
                        if(stack.isEmpty() || 0 != garden[x][y] || (stack.pop() != plantType) || garden[x][y] == -1) {
                            System.out.println("false");
                            printGarden(garden, n, m, reverseMap);
                            return;
                        } else {
                            garden[x][y] = plantType;
                        }
                    }
                }
            }
    
            System.out.println("true");
            printGarden(garden, n, m, reverseMap);
        }
    
        static void printGarden(int[][] arr, int n, int m, Map<Integer, String> map) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    System.out.print(map.get(arr[j][i]));
                }
                System.out.println();
            }
        }
    }