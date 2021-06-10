package com.example.oss_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<ExerciseData> list;

    public RecyclerViewAdapter(List<ExerciseData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_exercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExerciseData exercises = list.get(position);

        holder.bind(exercises);

        holder.itemView.setOnClickListener(v -> {
            boolean expanded = exercises.isExpanded();
            exercises.setExpanded(!expanded);
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;
        private TextView bodyPart;
        private TextView way;
        private TextView reps;
        private TextView extraExercise;
        private LinearLayout content;

        public ViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.exercise_image);
            name = view.findViewById(R.id.exercise_name);
            bodyPart = view.findViewById(R.id.body_part);
            way = view.findViewById(R.id.way);
            reps = view.findViewById(R.id.reps);
            extraExercise = view.findViewById(R.id.extra_exercise);
            content = view.findViewById(R.id.content);
        }

        private void bind(ExerciseData exercises) {
            boolean expanded = exercises.isExpanded();

            content.setVisibility(expanded ? View.VISIBLE : View.GONE);

            image.setImageResource(exercises.getImage());
            name.setText(exercises.getName());
            bodyPart.setText("\n<운동부위>\n" + exercises.getBodyPart());
            way.setText("\n<운동방법>\n" + exercises.getWayExercise());
            reps.setText("\n<운동횟수>\n" + exercises.getReps());
            extraExercise.setText("\n<응용동작>\n" + exercises.getExtraExercise());
        }
    }
}
