package Adm.Movie;

import java.util.ArrayList;
import java.util.Scanner;
import Date.Date;
public class MovieManager {
    // 私有属性
    private ArrayList<Movie> movies; // 影片对象的列表

    // 构造方法
    public MovieManager() {
        movies = new ArrayList<Movie>();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void listMovies() {
        if (movies.isEmpty()) { // 列表为空
            System.out.println("没有任何影片信息");
        } else { // 列表不为空
            System.out.println("以下是所有影片信息：");
            for (Movie movie : movies) { // 遍历列表
                // 打印每个影片对象的所有属性
                System.out.println("片名：" + movie.getTitle());
                System.out.println("导演：" + movie.getDirector());
                System.out.println("主演：" + String.join(", ", movie.getCast()));
                System.out.println("电影类型：" + movie.getGenre());
                System.out.println("剧情信息：" + movie.getPlot());
                System.out.println("电影时长：" + movie.getDuration() + "分钟");
                System.out.println();
            }
        }
    }

    // 添加影片信息
    public void addMovie() {
        Scanner scanner = new Scanner(System.in); // 创建扫描器对象
        System.out.println("请输入要添加的影片信息：");
        // 从用户输入获取各个属性的值
        System.out.print("片名：");
        String title = scanner.nextLine();
        System.out.print("导演：");
        String director = scanner.nextLine();
        System.out.print("主演：");
        String cast = scanner.nextLine();
        System.out.print("电影类型：");
        String genre = scanner.nextLine();
        System.out.print("剧情信息：");
        String plot = scanner.nextLine();
        System.out.print("电影时长（分钟）：");
        int duration = scanner.nextInt();

        // 创建一个新的影片对象，并赋值给各个属性
        Movie movie = new Movie(title, director, cast, genre, plot, duration);
        movies.add(movie); // 向列表中添加这个新的影片对象
        System.out.println("成功添加了一部新的影片：" + title);
    }

    // 修改影片信息
    public void modifyMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的影片的片名：");
        String title = scanner.nextLine();

        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) { // 找到了这部影片
                found = true;

                // 输入获取各个属性的新值，并赋值给这部影片对象
                System.out.println("请输入这部影片的新信息：");
                System.out.print("导演：");
                movie.setDirector(scanner.nextLine());
                System.out.print("主演（以逗号分隔）：");
                movie.setCast(scanner.nextLine());
                System.out.print("电影类型：");
                movie.setGenre(scanner.nextLine());
                System.out.print("剧情信息：");
                movie.setPlot(scanner.nextLine());
                System.out.print("电影时长（分钟）：");
                movie.setDuration(scanner.nextInt());

                System.out.println("成功修改了一部影片：" + title);
                break;
            }
        }

        if (!found) { // 没有找到这部影片
            System.out.println("没有找到这部影片：" + title);
        }
    }

    public int getMovieIndexByTitle(String name) {
        int i=0;
        for (;i<movies.size();i++) {
            if (movies.get(i).getTitle().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    // 删除影片信息
    public void deleteMovie() {
        Scanner scanner = new Scanner(System.in); // 创建扫描器对象
        System.out.println("请输入要删除的影片的片名：");
        String title = scanner.nextLine(); // 从用户输入获取要删除的影片的片名

        boolean found = false; // 标记是否找到了这部影片
        for (Movie movie : movies) { // 遍历列表
            if (movie.getTitle().equals(title)) { // 找到了这部影片
                found = true; // 更新标记为真

                System.out.println("你确定要删除这部影片吗？请输入y或n：");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    movies.remove(getMovieIndexByTitle(title));
                    System.out.println("成功删除了一部影片：" + title);
                } else { // 答案不是y
                    System.out.println("取消删除操作");
                }
                break; // 结束循环
            }
        }

        if (!found) { // 没有找到这部影片
            System.out.println("没有找到这部影片：" + title);
        }
    }

    // 根据片名找到并返回一个影片对象
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) { // 遍历列表
            if (movie.getTitle().equals(title)) { // 找到了这部影片
                return movie; // 返回这个影片对象
            }
        }
        return null; // 没有找到这部影片，返回空值
    }



}
